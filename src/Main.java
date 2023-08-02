import java.util.*;

public class Main {
    private ArrayList<School>schools=new ArrayList<School>();
    private HashMap<String,School>schoolsmap;
    public static void main(String[] args) {
        Main o=new Main();
        System.out.println(o.generateId());
    }
    public String  generateId(){
        String []letters={"a", "b", "c", "d", "e" ,"f","g","h" ,"i" ,"j" ,"k" ,"l" ,"m","n","o" ,"p" ,"q" ,"r" ,"s" ,"q","r","s","t","u" ,"v" ,"w" ,"x" ,"y" ,"z","10","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","ss","ssa","sss"};
        String id="";
        int numero=0;
        for (int i = 0; i <5; i++) {
            numero=(int)(Math.random()*letters.length-1);
            id+=letters[numero];

        }
        return id;
    }
    public String saveSchool(String nameSchool, String typeofSchool, String directionSchool){
        if (schools==null){
            schools=new ArrayList<School>();
            String id=generateId();
            schools.add(new School(id,nameSchool, typeofSchool, directionSchool));
            return "La escuela "+nameSchool +"Fue agregada correctamente"+ "con el id "+id;
        }else {
              return saveSchoolwithid(nameSchool, typeofSchool, directionSchool);
        }

    }
    public String saveSchoolwithid(String nameSchool, String typeofSchool, String directionSchool){
        String id=generateId();
        while (schools.contains(new School(id))){
            id=generateId();
        }
        schools.add(new School(id,nameSchool, typeofSchool, directionSchool));
        return "La escuela se agrego correctamente";
    }
    public boolean comprabeexitens(String id){
        return schools.contains(new School(id));
    }
    public String updateName(String name,String id){
        if (comprabeexitens(id)){
            School modi=schools.get(schools.indexOf(new School(id)));
            modi.setNameSchool(name);
            return "El nombre de la escuela con el codigo "+id+" ha sido modificado correactamente";
        }else {
            return "La escuela no existe";
        }

    }
    public String updatetypeofSchool(String typeOfSchool,String id){
        if (comprabeexitens(id)) {
            School modi = schools.get(schools.indexOf(new School(id)));
            modi.setTypeofSchool(typeOfSchool);
            return "El tipo de escuela de la escuela con el codigo " + id + " ha sido modificado correactamente";
        }else {
            return "La escuela no existe";
        }
    }
    public String updatedirectionschool(String directionofSchool,String id){
        if (comprabeexitens(id)) {
            School modi = schools.get(schools.indexOf(new School(id)));
            modi.setDirectionSchool(directionofSchool);
            return "La direccion de la escuela  con el id" + id + "fue modificada correctamente";
        }else {

                return "La escuela no existe";
        }

    }
    public ArrayList<School> orderAndReturn(){
        long totalSum = 0;
        long startTime = System.currentTimeMillis();
        ArrayList<School>schools=new ArrayList<School>();
        for (School o:schools) {
         schools.add(o);
        }
        for (int i = 0; i <schools.size() ; i++) {

            for (int j = 0; j < schools.size()-1 ; j++) {
                School actualElement=schools.get(j);
                School nextElement=schools.get(j+1);
                if (actualElement.getIdSchool().compareTo(nextElement.getIdSchool())>0){
                    schools.set(j,nextElement);
                    schools.set(j+1,actualElement);
                }
            }

        }
        totalSum+= (System.currentTimeMillis()-startTime);
        System.out.println("El tiempo de ejecucuion fue de "+ totalSum);
        return  schools;
    }
    public ArrayList<School>orderSort(){
        long totalSum = 0;
        long startTime = System.currentTimeMillis();
        ArrayList<School>schools=new ArrayList<School>();
        for (School o:schools) {
            schools.add(o);
        }
        Collections.sort(schools);
        totalSum+= (System.currentTimeMillis()-startTime);
        System.out.println("El tiempo de ejecucuion fue de "+ totalSum);
        return schools;
    }
    public HashMap<String,School>copymap(){
        if(schoolsmap==null){
            schoolsmap = new HashMap<String,School>();
            for (School o:schools
                 ) {

                schoolsmap.put(o.getIdSchool(),o);

            }
        }
        return schoolsmap;
    }
    public int binarySerach(ArrayList<School>arreglo,String id){
        long totalSum = 0;
        long startTime = System.currentTimeMillis();
        int l=0,r=arreglo.size()-1;
        while (l<=r){
            int m=l+(r-1)/2;
            if(arreglo.get(m).equals(id)){
                return m;
            }
            if (!arreglo.get(m).equals(id)){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        totalSum+= (System.currentTimeMillis()-startTime);
        System.out.println("El tiempo de ejecucuion fue de "+ totalSum);
        return -1;
    }
    public School obtenshashelemnent(String id){
        long totalSum = 0;
        long startTime = System.currentTimeMillis();
        if (schoolsmap==null){
            totalSum+= (System.currentTimeMillis()-startTime);
            System.out.println("El tiempo de ejecucuion fue de "+ totalSum);
            return null;
        }else {
            totalSum+= (System.currentTimeMillis()-startTime);
            System.out.println("El tiempo de ejecucuion fue de "+ totalSum);
            return schoolsmap.get(id);
        }

    }
    public String deleteSchool(String id){
        if (!comprabeexitens(id)){
            return "La escuela no existe por lo tanto no se puede eliminar ";
        }else {
            schools.remove(new School(id));
            return "La escuela con el id  "+id +" se ha removido correctamente";
        }
    }
    


}