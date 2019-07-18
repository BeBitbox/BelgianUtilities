package be.bitbox.belgianutilities;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NisCodeTest {

    @Test(expected = IllegalArgumentException.class)
    public void emptyCode_ExpectError() {
        new NisCode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCode_ExpectError() {
        new NisCode("ab890");
    }

    @Test(expected = IllegalArgumentException.class)
    public void gewestBuitenRanges_ExpectError() {
        new NisCode("9099890");
    }

    @Test
    public void testGewesten() {
        assertThat(new NisCode("10000").inGewest()).isEqualTo(Gewest.VLAAAMS_GEWEST);  //NISCODE ANTWERPEN
        assertThat(new NisCode("13025").inGewest()).isEqualTo(Gewest.VLAAAMS_GEWEST);  //MOL
        assertThat(new NisCode("21005").inGewest()).isEqualTo(Gewest.BRUSSELS_GEWEST); //ETTERBEEK
        assertThat(new NisCode("23016").inGewest()).isEqualTo(Gewest.VLAAAMS_GEWEST);  //DILBEEK
        assertThat(new NisCode("25081").inGewest()).isEqualTo(Gewest.WAALS_GEWEST);    //ORBAIS
        assertThat(new NisCode("34002").inGewest()).isEqualTo(Gewest.VLAAAMS_GEWEST);  //ANZEGEM
        assertThat(new NisCode("44011").inGewest()).isEqualTo(Gewest.VLAAAMS_GEWEST);  //DEINZE
        assertThat(new NisCode("44083").inGewest()).isEqualTo(Gewest.VLAAAMS_GEWEST);  //DEINZE (GEFUSSIONEERD)
        assertThat(new NisCode("57054").inGewest()).isEqualTo(Gewest.WAALS_GEWEST);    //MOLENBAIX
        assertThat(new NisCode("62097").inGewest()).isEqualTo(Gewest.WAALS_GEWEST);    //SLINS
        assertThat(new NisCode("71016").inGewest()).isEqualTo(Gewest.VLAAAMS_GEWEST);  //GENK
        assertThat(new NisCode("83009").inGewest()).isEqualTo(Gewest.WAALS_GEWEST);    //BORLON
        assertThat(new NisCode("92046").inGewest()).isEqualTo(Gewest.WAALS_GEWEST);    //FLORIFFOUX
    }
}