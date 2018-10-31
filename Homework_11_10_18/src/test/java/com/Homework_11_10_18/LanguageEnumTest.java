package com.Homework_11_10_18;

import com.Homework_11_10_18.Enums.LanguageEnum;
import org.junit.Test;

import static org.junit.Assert.*;

public class LanguageEnumTest {

    @Test
    public void getEnum_correctLanguageId_returnLanguage() {
        int id =2;
        LanguageEnum language= LanguageEnum.getEnum(id);
        assertEquals(LanguageEnum.RU,language);
    }
    @Test
    public void getEnum_wrongLanguageId_returnDefaultEN() {
        int id =10;
        LanguageEnum language= LanguageEnum.getEnum(id);
        assertEquals(LanguageEnum.EN,language);
    }
}