package com.example.settingsservice.model;

public class privacyDTO {
    private Boolean allowNotifs;
    private Boolean isPrivate;
    private Boolean acceptMsg;
    private Boolean taggable;

    public privacyDTO(Boolean allowNotifs, Boolean isPrivate, Boolean acceptMsg, Boolean taggable) {
        this.allowNotifs = allowNotifs;
        this.isPrivate = isPrivate;
        this.acceptMsg = acceptMsg;
        this.taggable = taggable;
    }

    public privacyDTO() {
    }

    public Boolean getAllowNotifs() {
        return allowNotifs;
    }

    public void setAllowNotifs(Boolean allowNotifs) {
        this.allowNotifs = allowNotifs;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Boolean getAcceptMsg() {
        return acceptMsg;
    }

    public void setAcceptMsg(Boolean acceptMsg) {
        this.acceptMsg = acceptMsg;
    }

    public Boolean getTaggable() {
        return taggable;
    }

    public void setTaggable(Boolean taggable) {
        this.taggable = taggable;
    }
}
