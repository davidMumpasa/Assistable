package com.example.assistable.controllers;

import com.example.assistable.models.User;
import com.example.assistable.models.UserEntity;
import com.example.assistable.models.UserServices;
import com.example.assistable.service.AccountService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserServices userServices;
    private static final String API_URL = "https://veriid.com/Sandbox/webservice/pbverify-profile-id-verification";
    private AccountService accountService;
    public void UserServices(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/user/useId")
    public ResponseEntity<User> verifyPersonInfo(@RequestParam("idNumber") String idNumber) {

        // Check if ID number has 13 digits
        if (idNumber.length() != 13) {
            String errorMessage = "Invalid ID number. It must be 13 digits.";
            User person = new User();
            person.setErrorMessage(errorMessage);
            return ResponseEntity.badRequest().body(person);
        }

        OkHttpClient client = new OkHttpClient();

        // Build the request body
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("memberkey", "PB-FLU001")
                .addFormDataPart("password", "6d66a9c5a464fa15acc71da4daf6ca25")
                .addFormDataPart("consumer_details[idNumber]", idNumber)
                .addFormDataPart("consumer_details[yourReference]", "test")
                .build();

        // Build the request
        Request request = new Request.Builder()
                .url(API_URL)
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            // Send the request and get the response
            Response response = client.newCall(request).execute();

            // Process the response
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                Gson gson = new Gson();
                User person = gson.fromJson(responseBody, User.class);
                person.setStatus("success");
                // Save user details to the database
                UserEntity userEntity = new UserEntity();
                userEntity.setFirstname(person.getIdProfile().getFirstNames());
                userEntity.setLastname(person.getIdProfile().getSurName());
                userEntity.setIdNumber(person.getIdProfile().getIdNumber());
                userEntity.setDob(person.getIdProfile().getDob());
                userEntity.setGender(person.getIdProfile().getGender());
                userEntity.setCitizenship(person.getIdProfile().getCitizenship());

                userServices.save(userEntity); // Save user details to the database

                return ResponseEntity.ok(person);
            } else {
                // Handle error response
                String errorMessage = "Request failed: " + response.code() + " - " + response.message();
                User person = new User();
                person.setErrorMessage(errorMessage);
                return ResponseEntity.status(response.code()).body(person);
            }
        } catch (Exception e) {
            // Handle exception
            User person = new User();
            System.out.println("An error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(person);
        }

    }

    @PostMapping("/bank-account-verification")
    public String  verifyBankAccount(@RequestParam("accountNumber") String accountNumber,@RequestParam("idNumber") String idNumber
            ,@RequestParam("accountType") String accountType,@RequestParam("branchCode") String branchCode,@RequestParam("branchCode") String yourReference) throws IOException, IOException {
        OkHttpClient client = new OkHttpClient();

        // Build the request body
        RequestBody body = accountService.buildRequestBody(accountNumber,idNumber,accountType,branchCode,yourReference);
        // Build Request
        Request request = accountService.buildRequest(body);

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        return responseBody;
    }

}

