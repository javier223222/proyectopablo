import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<School>schools;
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
    public String updateName(String name,String id){
        School modi=schools.get(schools.indexOf(new School(id)));
        modi.setNameSchool(name);
        return "El nombre de la escuela con el codigo "+id+" ha sido modificado correactamente";
    }
    public String updatetypeofSchool(String typeOfSchool,String id){
        School modi=schools.get(schools.indexOf(new School(id)));
        modi.setTypeofSchool(typeOfSchool);
        return      "El tipo de escuela de la escuela con el codigo "+ id+" ha sido modificado correactamente";

    }
    public String updatedirectionschool(String directionofSchool,String id){
        School modi=schools.get(schools.indexOf(new School(id)));
        modi.setDirectionSchool(directionofSchool);
        return "La direccion de la escuela  con el id"+id +"fue modificada correctamente";

    }
    public ArrayList<School> orderAndReturn(ArrayList<School>arreglo){
        ArrayList<School>schools=new ArrayList<School>();
        for (School o:arreglo) {
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
        return  schools;
    }

}