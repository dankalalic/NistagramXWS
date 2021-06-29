package com.example.settingsservice.model;

public class privacyDTO {
    private Boolean allowNotifs;
    private Boolean isp;
    private Boolean acceptMsg;
    private Boolean taggable;

    public privacyDTO(Boolean allowNotifs, Boolean isp, Boolean acceptMsg, Boolean taggable) {
        this.allowNotifs = allowNotifs;
        this.isp = isp;
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

    public Boolean getIsp() {
        return isp;
    }

    public void setIsp(Boolean isp) {
        this.isp = isp;
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
