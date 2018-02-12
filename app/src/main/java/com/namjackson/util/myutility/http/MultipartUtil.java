package com.namjackson.util.myutility.http;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by namjai on 2017-10-30.
 * RetriFit의 파일전송으위해
 */

public class MultipartUtil {
    final static public String AND = "&&";
    @NonNull
    public static RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                MultipartBody.FORM, descriptionString);
    }
    @NonNull
    public static MultipartBody.Part prepareFilePart(Context context, String partName, String fileName, byte[] photo) {
        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
        // use the FileUtils to get the actual file by uri
        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse("image/jpg"),
                        photo
                );
        return MultipartBody.Part.createFormData(partName,fileName, requestFile);
    }
   @NonNull
    public static MultipartBody.Part prepareFilePart(Context context, String partName, File file) {
        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
        // use the FileUtils to get the actual file by uri
        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse("image/jpg"),
                        file
                );
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }

    @NonNull
    public static List<MultipartBody.Part> prepareFileListPart(List<Document> list) {
        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
        // use the FileUtils to get the actual file by uri
        // create RequestBody instance from file
        List<MultipartBody.Part> partList = new ArrayList<>();
        for(Document doc : list){
            RequestBody requestFile = RequestBody.create(
                            MediaType.parse("image/jpg"),
                            doc.getPhoto()
                    );
            Gson gson = new Gson();
            doc.setPhoto(null);
//            doc.createByDisplayName=null;
            String json = gson.toJson(doc);
            try{
                partList.add(MultipartBody.Part.createFormData("file", URLEncoder.encode(json, "UTF-8"), requestFile));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return partList;
    }


}
