public class Cont implements Comparable<Cont> {
    private String UUID;
    private String SHORTNAME;
    private String LONGNAME;

    public String getUUID() {
        return UUID;
    }


    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getSHORTNAME() {
        return SHORTNAME;
    }

    public void setSHORTNAME(String SHORTNAME) {
        this.SHORTNAME = SHORTNAME;
    }

    public String getLONGNAME() {
        return LONGNAME;
    }

    public void setLONGNAME(String LONGNAME) {
        this.LONGNAME = LONGNAME;
    }

    @Override
    public String toString() {
        return " <CONTAINER UUID="+UUID+
                ">\n <SHORT-NAME>" + SHORTNAME +"</SHORT-NAME>\n"+
                " <LONG-NAME>" + LONGNAME + "</LONG-NAME>\n"+" </CONTAINER>\n";
    }


    @Override
    public int compareTo(Cont o){
        return this.SHORTNAME.compareTo(o.SHORTNAME);

    }
}