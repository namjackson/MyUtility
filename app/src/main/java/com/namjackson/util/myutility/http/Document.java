package com.namjackson.util.myutility.http;

/**
 * Created by VisionIC on 2017-11-27.
 */

public class Document  {

    private String ownerTable;	//테이블
    private String ownerId;		//키값

    private String docinfoId;	//DocInfoID -

    private String document;	//document
    private String doDesc;		//docInfo desc
    private String docType;		//type : image ,attach 등


    private String doVersion;
    private String urlName;		//url
    private String fileName;

    private String createBy;
    private String createDt;

    private byte[] photo;		//이미지

    private String imageName;    //이미지 저장경로


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDocinfoId() {
        return docinfoId;
    }
    public void setDocinfoId(String docinfoId) {
        this.docinfoId = docinfoId;
    }
    public String getOwnerTable() {
        return ownerTable;
    }
    public void setOwnerTable(String ownerTable) {
        this.ownerTable = ownerTable;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDoDesc() {
        return doDesc;
    }

    public void setDoDesc(String doDesc) {
        this.doDesc = doDesc;
    }
    public String getDocType() {
        return docType;
    }
    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDoVersion() {
        return doVersion;
    }

    public void setDoVersion(String doVersion) {
        this.doVersion = doVersion;
    }
    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }


}
