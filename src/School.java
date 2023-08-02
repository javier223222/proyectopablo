public class School implements Comparable<School> {
    private String idSchool;
    private String nameSchool;
    private String typeofSchool;
    private String directionSchool;

    public String getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(String idSchool) {
        this.idSchool = idSchool;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public String getTypeofSchool() {
        return typeofSchool;
    }

    public void setTypeofSchool(String typeofSchool) {
        this.typeofSchool = typeofSchool;
    }

    public String getDirectionSchool() {
        return directionSchool;
    }

    public void setDirectionSchool(String directionSchool) {
        this.directionSchool = directionSchool;
    }


    public School(String idSchool, String nameSchool, String typeofSchool, String directionSchool) {
        this.idSchool = idSchool;
        this.nameSchool = nameSchool;
        this.typeofSchool = typeofSchool;
        this.directionSchool = directionSchool;
    }

    public School(String idSchool) {
        this.idSchool = idSchool;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        School school = (School) o;

        return idSchool.equals(school.idSchool);
    }

    @Override
    public String toString() {
        return "School{" +
                "Codigo de la escuela='" + idSchool + '\'' +
                ", Nombre de la escuela='" + nameSchool + '\'' +
                ", Tipo de escuela ='" + typeofSchool + '\'' +
                ", Direccion de la Escuela ='" + directionSchool + '\'' +
                '}';
    }
    @Override
    public int compareTo(School o) {
        return this.idSchool.compareTo(o.idSchool);
    }
}
