package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;


public class Recombination2<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    //TODO this class might require the definition of additional methods and/or attributes

    public Recombination2(double probability) {
        super(probability);
    }

    @Override
    public void recombine(I ind1, I ind2) {
        int[] child1=new int[ind1.getNumGenes()];
        int[] child2=new int[ind2.getNumGenes()];
        int crossPoint1=GeneticAlgorithm.random.nextInt(ind1.getNumGenes()/2);
        int crossPoint2=GeneticAlgorithm.random.nextInt(ind2.getNumGenes()/2);
        while (crossPoint2>=crossPoint1){
            crossPoint2=GeneticAlgorithm.random.nextInt(ind2.getNumGenes()/2);
        }
        for (int i = 0; i <crossPoint1; i++) {
            child1[i]=0;
            child2[i]=0;
        }
        for (int i = crossPoint2+1; i <ind1.getNumGenes() ; i++) {
            child1[i]=0;
            child2[i]=0;
        }
    }

    @Override
    public String toString(){
        //TODO
        throw new UnsupportedOperationException();
    }    
}