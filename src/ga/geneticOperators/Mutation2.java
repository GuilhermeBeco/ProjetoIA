package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;


public class Mutation2<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation2(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {
        int[] cuts = new int[3];
        for (int i = 0; i < cuts.length - 1; i++) {
            cuts[i] = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
            if (i != 0) {
                while (cuts[i] == cuts[i - 1]) {
                    cuts[i] = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
                }
            }
        }

        int split=ind.getNumGenes()/2;

        for (int i = 0; i <cuts.length-1; i++) {
            int aux = ind.getGene(split - cuts[i]/2);
            ind.setGene(split - cuts[i]/2, ind.getGene(split+cuts[i]/2));
            ind.setGene(split + cuts[i]/2, aux);
        }

    }

    @Override
    public String toString() {
       return "Mutation 2";
    }
}