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
        int [] child1=new int[ind1.getNumGenes()/2];
        int [] child2=new int[ind2.getNumGenes()/2];
        int crossPoint= GeneticAlgorithm.random.nextInt(ind1.getNumGenes()/2);
        for (int i = 0; i <crossPoint; i++) {
            child1[i]=ind1.getGene(i);
            child2[i]=ind2.getGene(i);
        }
        int j=0;
        for (int i = crossPoint; i <crossPoint+ind1.getNumGenes(); i++) {
            ind1.setGene(i,child2[j]);
            ind2.setGene(i,child1[j]);
            j++;
        }

    }

    @Override
    public String toString(){
        //TODO
        throw new UnsupportedOperationException();
    }    
}