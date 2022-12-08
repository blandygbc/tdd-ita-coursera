package test.java.com.blandygbc.translator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.com.blandy.translator.Translator;

public class TranslatorTest {

    Translator translator;

    @Before
    public void createTranslator() {
        translator = new Translator();
    }

    @Test
    public void translatorWithoutWords() {
        assertTrue(translator.isEmpty());
    }

    @Test
    public void oneTranslation() {
        translator.addTranslation("good", "bom");
        assertFalse(translator.isEmpty());
        assertEquals("bom", translator.translate("good"));
    }

    @Test
    public void twoTranslation() {
        translator.addTranslation("good", "bom");
        translator.addTranslation("bad", "mau");
        assertEquals("bom", translator.translate("good"));
        assertEquals("mau", translator.translate("bad"));
    }

    @Test
    public void twoTranslationSameWord() {
        translator.addTranslation("nice", "legal");
        translator.addTranslation("nice", "bom");
        assertEquals("legal, bom", translator.translate("nice"));
    }

    @Test
    public void translatePhrase() {
        translator.addTranslation("war", "guerra");
        translator.addTranslation("is", "é");
        translator.addTranslation("bad", "ruim");
        assertEquals("guerra é ruim", translator.translatePhrase("war is bad"));
    }

    @Test
    public void translatePhraseWithTwoTranslationForSameWord() {
        translator.addTranslation("war", "guerra");
        translator.addTranslation("is", "é");
        translator.addTranslation("bad", "ruim");
        translator.addTranslation("bad", "mau");
        assertEquals("guerra é ruim", translator.translatePhrase("war is bad"));
    }
}
