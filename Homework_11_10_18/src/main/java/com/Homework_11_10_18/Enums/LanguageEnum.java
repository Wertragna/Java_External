package com.Homework_11_10_18.Enums;

public enum  LanguageEnum {
    EN("en",1, "English"),
    RU ("ru",2,"Русский");
   // UA("ukr",3);

    private String langCode;
    private int id;
    private String name;

    LanguageEnum(String langCode,int id, String name) {
        this.langCode = langCode;
        this.id= id;
        this.name= name;
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
        return id+") Language" +
                " '" + langCode + '\'' +
                " " + name;
    }
}
