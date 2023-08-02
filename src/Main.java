import java.sql.SQLOutput;
import java.util.*;

public class Main {
    private ArrayList<School>schools=new ArrayList<School>();
    private HashMap<String,School>schoolsmap=new HashMap<>();
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        Main o=new Main();
        System.out.println(o.generateId());
        if(o.confirmarUsuario()){
            int opcion=0;
            do {
                System.out.println("Bienvenido al menu");
                System.out.println("1. Agregar lista de escuelas");
                System.out.println("2. Modificar una escuela");
                System.out.println("3. Ordenas y copiar lista(burbuja)");
                System.out.println("4. Ordenas y copiar lista(insercion)");
                System.out.println("5. Ordenas y copiar lista(colecion sort)");
                System.out.println("6. Pasar lista al mapa");
                System.out.println("7. Buscar");
                System.out.println("8. Buscar(Hash Map)");
                System.out.println("9. Eliminar");
                System.out.println("10. salir");
                opcion=entrada.nextInt();
                switch (opcion){
                    case 1 ->{
                        System.out.println("ingrese el nombre");
                        String nombre=entrada.next();
                        System.out.println("ingrese el tipo");
                        String tipo=entrada.next();
                        System.out.println("ingrese la direccion");
                        String direccion=entrada.next();
                        System.out.println(o.saveSchool(nombre,tipo,direccion));
                    }
                    case 2 ->{
                        System.out.println("ingrese el id:");
                        String id=entrada.next();
                        System.out.println("que desea modificar?");
                        System.out.println("1. NOMBRE");
                        System.out.println("2. TIPO");
                        System.out.println("3. DIRECCION");
                        int opcion1=entrada.nextInt();
                        switch (opcion1) {
                            case 1 -> {
                                System.out.println("ingrese el nuevo nombre");
                                String nombre=entrada.next();
                                System.out.println(o.updateName(nombre,id));
                            }
                            case 2 ->{
                                System.out.println("ingrese el nuevo tipo");
                                String tipo=entrada.next();
                                System.out.println(o.updatetypeofSchool(tipo,id));
                            }
                            case 3 -> {
                                System.out.println("ingrese la nueva direccion");
                                String direccion=entrada.next();
                                System.out.println(o.updatedirectionschool(direccion,id));
                            }
                        }
                    }
                    case 3 -> System.out.println(o.orderAndReturn().toString());
                    case 4 -> System.out.println(o.orderAndReturnInsercion().toString());
                    case 5 -> System.out.println(o.orderSort().toString());
                    case 6 -> System.out.println(o.copymap().toString());
                    case 7 ->{
                        System.out.println("ingresar id a buscar:");
                        String id=entrada.next();
                        System.out.println("los datos de la escuela son "+o.getSchools().get(o.binarySerach(id)).toString());
                    }
                    case 8 ->{
                        System.out.println("ingresar id a buscar:");
                        String id=entrada.next();
                        System.out.println(o.obtenshashelemnent(id));
                    }
                    case 9 ->{
                        System.out.println("ingrese el id");
                        String id= entrada.next();
                        System.out.println(o.deleteSchool(id));
                    }
                }
            }while (opcion!=10);
        }else{
            System.out.println("se bloquedo");
        }
    }
    public boolean confirmarUsuario(){
        int contador=1,key=1234;
        String admin="pedrop";
        Scanner entrada=new Scanner(System.in);
        String usuario;
        int password;
        do {
            do {
                System.out.println("ingrese el usuario  intento: "+contador);
                usuario=entrada.next();
                if(usuario.length()!=6) {
                    System.out.println("el usuario debe tener 6 caracteres");
                }
                if (!usuario.equals(admin))
                    System.out.println("usuario incorrecto");
                else
                    System.out.println("usuario correcto");
            }while (!usuario.equals(admin));
            System.out.println("ingrese el password:   intento: "+contador);
                password=entrada.nextInt();
            if (password<1000 || password>9999)
                System.out.println("el password es solo de 4 digitos");
            if (password!=key)
                System.out.println("password incorrecto vuelva a intentar");
            if (password==key)
                return true;
            if(contador==3){
                System.out.println("desea seguir intentando?  1.si 2.no");
                int opcion=entrada.nextInt();
                if (opcion==1){
                    contador=0;
                }
            }
            contador++;
        }while (contador<=3);
        return false;
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

        ArrayList<School>schools2=new ArrayList<School>();
        for (School o:schools) {
         schools2.add(o);
        }

        for (int i = 0; i <schools2.size() ; i++) {

            for (int j = 0; j < schools2.size()-1 ; j++) {
                School actualElement=schools2.get(j);
                School nextElement=schools2.get(j+1);
                if (actualElement.getIdSchool().compareTo(nextElement.getIdSchool())>0){
                    schools2.set(j,nextElement);
                    schools2.set(j+1,actualElement);
                }
            }

        }
        totalSum+= (System.currentTimeMillis()-startTime);
        System.out.println("El tiempo de ejecucuion fue de "+ totalSum);
        return  schools;
    }
    public ArrayList<School> orderAndReturnInsercion() {
        long totalSum = 0;
        long startTime = System.currentTimeMillis();
        ArrayList<School> schools2 = new ArrayList<School>();
        for (School o:schools) {
            schools2.add(o);
        }
        for (int i = 1; i < schools2.size(); i++) {
            School key = schools2.get(i);
            int j = i - 1;

            while (j >= 0 && schools2.get(j).getIdSchool().compareTo(key.getIdSchool()) > 0) {
                schools2.set(j + 1, schools2.get(j));
                j--;
            }
            schools2.set(j + 1, key);
        }
        totalSum += (System.currentTimeMillis() - startTime);
        System.out.println("El tiempo de ejecución fue de " + totalSum);
        return schools2;
    }

    public ArrayList<School>orderSort(){
        long totalSum = 0;
        long startTime = System.currentTimeMillis();
        ArrayList<School>schools2=new ArrayList<School>();
        for (School o:schools) {
            schools2.add(o);
        }
        Collections.sort(schools2);
        totalSum+= (System.currentTimeMillis()-startTime);
        System.out.println("El tiempo de ejecucuion fue de "+ totalSum);
        return schools2;
    }
    public HashMap<String,School>copymap(){
        if(schoolsmap==null){

            for (School o:schools
                 ) {
                schoolsmap.put(o.getIdSchool(),o);
            }
        }else {

            for (School o:schools
            ) {
                schoolsmap.put(o.getIdSchool(),o);
            }
        }
        return schoolsmap;
    }
    public int binarySerach(String id){
        long totalSum = 0;
        long startTime = System.currentTimeMillis();
        int l=0,r=schools.size()-1;
        while (l<=r){
            int m=(l+r)/2;
            if(schools.get(m).getIdSchool().compareTo(id)<0){
                l=m+1;
            }else if(schools.get(m).getIdSchool().compareTo(id)>0){
                r=m-1;
            }else {
                return m;
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

    public ArrayList<School> getSchools() {
        return schools;
    }

    public void setSchools(ArrayList<School> schools) {
        this.schools = schools;
    }

    public HashMap<String, School> getSchoolsmap() {
        return schoolsmap;
    }

    public void setSchoolsmap(HashMap<String, School> schoolsmap) {
        this.schoolsmap = schoolsmap;
    }
}