public class PetrolPumpProblem{
    static class PetrolPump{
        int petrol;
        int distance;
        PetrolPump(int p, int d){
            this.petrol = p;
            this.distance =d;
        }
    }
    
    // finding circle
    static void getStart(PetrolPump [] pp){
        int num = pp.length;
        int start = 0, end = 1;
        int petrol_start = pp[start].petrol - pp[start].distance;
        while(petrol_start < 0 || start !=end){
            while((petrol_start < 0) &&(start != end)){
                //removing previous petrol pump and changing start for it.
                start = (start+1) % num;
                petrol_start = pp[start].petrol - pp[start].distance;
                if(start==0){
                    return ;
                }
            }
            petrol_start += pp[end].petrol - pp[end].distance;
            end = (end+1)%num;
        }
        System.out.println(start);
    }
    
    public static void main(String [] args){
        PetrolPump [] pp = {new PetrolPump(2,6),
                            new PetrolPump(3,6),
                            new PetrolPump(1,3)};
        getStart(pp);
                        
    }
}

