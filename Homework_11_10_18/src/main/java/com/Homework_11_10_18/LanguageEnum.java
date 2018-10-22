package com.Homework_11_10_18;

import javax.swing.event.MenuListener;

public enum  LanguageEnum {
    EN("en",1),
    RU("ru",2),
    UA("ukr",3);

    private String langCode;
    private int id;
    LanguageEnum(String langCode,int id) {
        this.langCode = langCode;
        this.id= id;
    }

    public int getId() {
        return id;
    }

    public String getLangCode() {
        return langCode;
    }
    public static LanguageEnum getEnum(int value) {
        for(LanguageEnum v : values())
            if(v.getId()==value)
                return v;
        return EN;
    }

    @Override
    public String toString() {
        return "LanguageEnum{" +
                "langCode='" + langCode + '\'' +
                ", id=" + id +
                "} " + super.toString();
    }
}
