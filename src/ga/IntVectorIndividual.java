package ga;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.Random;

public abstract class IntVectorIndividual<P extends Problem, I extends IntVectorIndividual> extends Individual<P, I> {
    //TODO this class might require the definition of additional methods and/or attributes

    protected int[] genome;
    public IntVectorIndividual(P problem, int size) {
        super(problem);
        genome = new int[size];

        for (int i = 0; i < size; i++) {
            if(i==0){
                genome[i]=new Random().nextInt(10)+1;
            }else {
                int num=0;
                do{
                    num=new Random().nextInt(10)+1;
                }while(check(i,num));
                genome[i]=num;

            }
        }

      }

    private boolean check(int i,int num) {
        for(int j=0;j<i;j++){
            if(genome[j]==num){
                return true;
            }
        }
        return false;
    }

    public IntVectorIndividual(IntVectorIndividual<P, I> original) {
        super(original);
        this.genome = new int[original.genome.length];
        System.arraycopy(original.genome, 0, genome, 0, genome.length);
    }

    @Override
    public int getNumGenes() {
        return genome.length;
    }

    public int getIndexof(int value){
        for (int i = 0; i < genome.length; i++) {
            if (genome[i] == value)
                return i;
        }
        return -1;
    }

    public int getGene(int index) {
        return genome[index];
    }

    public void setGene(int index, int newValue) {
        genome[index] = newValue;
    }

    @Override
    public void swapGenes(IntVectorIndividual other, int index) {
        int aux = genome[index];
        genome[index] = other.genome[index];
        other.genome[index] = aux;
    }
}
