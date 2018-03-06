package com.example.akshaygudi.myapp;

public class CustomListPojo {

    private Integer imageId;
    private String imageName;

    public CustomListPojo(){

    }

    public CustomListPojo(int ImageId, String imageName){
        this.imageId = ImageId;
        this.imageName = imageName;
    }


    public Integer getImageId() {
        return imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString(){
        return this.imageName + " --- " + this.imageId;
    }



}
