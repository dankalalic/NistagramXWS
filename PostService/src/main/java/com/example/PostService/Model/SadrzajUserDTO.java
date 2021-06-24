package com.example.PostService.Model;

public class SadrzajUserDTO {
    private Integer sadrzajId;
    private Integer userId;

    public SadrzajUserDTO(Integer sadrzajId, Integer userId) {
        this.sadrzajId = sadrzajId;
        this.userId = userId;
    }

    public SadrzajUserDTO() {
    }

    public Integer getSadrzajId() {
        return sadrzajId;
    }

    public void setSadrzajId(Integer sadrzajId) {
        this.sadrzajId = sadrzajId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
