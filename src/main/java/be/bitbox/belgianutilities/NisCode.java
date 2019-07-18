package be.bitbox.belgianutilities;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class NisCode {
    private static Range<Integer> ANTWERPEN = Range.closedOpen(10000, 20000);
    private static Range<Integer> BRUSSEL_STAD = Range.closedOpen(20000, 22000);
    private static Range<Integer> VLAAMS_BRABANT = Range.closedOpen(22000, 25000);
    private static Range<Integer> WAALS_BRABANT = Range.closedOpen(25000, 30000);
    private static Range<Integer> WEST_VLAANDEREN = Range.closedOpen(30000, 40000);
    private static Range<Integer> OOST_VLAANDEREN = Range.closedOpen(40000, 50000);
    private static Range<Integer> HENEGOUWEN = Range.closedOpen(50000, 60000);
    private static Range<Integer> LUIK = Range.closedOpen(60000, 70000);
    private static Range<Integer> LIMBURG = Range.closedOpen(70000, 80000);
    private static Range<Integer> LUXEMBURG = Range.closedOpen(80000, 90000);
    private static Range<Integer> NAMEN = Range.closedOpen(90000, 100000);


    private static RangeSet<Integer> VLAANDEREN = TreeRangeSet.create();
    private static RangeSet<Integer> WALLONIE = TreeRangeSet.create();
    private static RangeSet<Integer> BRUSSEL = TreeRangeSet.create();


    static {
        VLAANDEREN.add(ANTWERPEN);
        VLAANDEREN.add(VLAAMS_BRABANT);
        VLAANDEREN.add(WEST_VLAANDEREN);
        VLAANDEREN.add(OOST_VLAANDEREN);
        VLAANDEREN.add(LIMBURG);
        WALLONIE.add(WAALS_BRABANT);
        WALLONIE.add(HENEGOUWEN);
        WALLONIE.add(LUIK);
        WALLONIE.add(LUXEMBURG);
        WALLONIE.add(NAMEN);
        BRUSSEL.add(BRUSSEL_STAD);
    }

    private final int nisCode;
    private final Gewest gewest;

    public NisCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Geen code ontvangen");
        }

        nisCode = bepaalNisCode(code);
        gewest = bepaalGewest();
    }

    private int bepaalNisCode(String code) {
        try {
            return Integer.parseInt(code);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Geen geldig getal", ex);
        }
    }

    private Gewest bepaalGewest() {
        if (VLAANDEREN.contains(nisCode)) {
            return Gewest.VLAAAMS_GEWEST;
        } else if (WALLONIE.contains(nisCode)) {
            return Gewest.WAALS_GEWEST;
        } else if (BRUSSEL.contains(nisCode)) {
            return Gewest.BRUSSELS_GEWEST;
        }
        throw new IllegalArgumentException("Niscode valt niet binnen een gewest");
    }

    public Gewest inGewest() {
        return gewest;
    }
}
