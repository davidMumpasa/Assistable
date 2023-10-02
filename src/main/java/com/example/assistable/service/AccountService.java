package com.example.assistable.service;

import lombok.Getter;
import lombok.Setter;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.stereotype.Service;

@Service
@Setter
@Getter
public class AccountService {
    public String errorMessage;
    public String url;


    public RequestBody buildRequestBody(String accountNumber,String idNumber,String accountType, String branchCode,String yourReference){

        okhttp3.MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("memberkey", "PB-FLU001")
                .addFormDataPart("password","062fd17a5e1b41b4e627406410e4769d")
                .addFormDataPart("bvs_details[accountNumber]",accountNumber)
                .addFormDataPart("bvs_details[idNumber]",idNumber)
                .addFormDataPart("bvs_details[accountType]",accountType)
                .addFormDataPart("bvs_details[branchCode]",branchCode)
                .addFormDataPart("bvs_details[yourReference] ",yourReference)
                .build();

        return body;
    }

    public Request buildRequest(RequestBody body){
        // Build the request
        Request request = new Request.Builder()
                .url("https://veriid.com/PBVerify/webservice/pbverify-bank-account-verification-v3")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "laravel_session=eyJpdiI6IlQ0N0U2NENXUk1QMTV1SjlpUkM4dmc9PSIsInZhbHVlIjoiZVZHRFJSelIwbzE4b0tGV2F0ZnZFcFlRbmRyeFJEU3hEMTBLMWN4Zyttd1NqODRVaWQycjk1cFlLNThxejFYRk1nXC9Ta2VEZzU1b3hrN3pkQVBqXC8yQT09IiwibWFjIjoiMTA5MDcwYTY2Yzk1NzMyNmE4OTU2Y2M4YjlkODBlZmM4MWI2MjQzZWI5MjExZDk1OWM2YTQ2OTBkOGRmZDFjMSJ9; pbverify-chocchip=3647aed5ed80c78a7c47c5dbcd3d6516|1676eed65626ff656c4990ede0fde4aa")
                .build();

        return request;
    }


}
