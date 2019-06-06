package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;
public class Mutation4<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation4(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {

       int amount=GeneticAlgorithm.random.nextInt(ind.getNumGenes()/2);
       while(amount==0)
           amount=GeneticAlgorithm.random.nextInt(ind.getNumGenes()/2);

        int i=0;
        int j=ind.getNumGenes()-amount-1;
        int auxFirst=0;
        System.out.println(amount);
        while(i<amount){
            auxFirst=ind.getGene(i);
            ind.setGene(i,ind.getGene(j));
            ind.setGene(j,auxFirst);
            i++;
            j++;

        }
    }

    @Override
    public String toString() {
        return "mutation 3";
    }
}