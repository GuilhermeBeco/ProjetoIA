package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class Mutation3<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation3(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {
    int amount=GeneticAlgorithm.random.nextInt(ind.getNumGenes()/2);
    while((amount%2)!=0 && amount<0){
        amount=GeneticAlgorithm.random.nextInt(ind.getNumGenes()/2);
    }
    int pos=GeneticAlgorithm.random.nextInt(ind.getNumGenes());
    while((pos+amount)>ind.getNumGenes()) {
        pos = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
    }
    int split=amount/2;
    for (int i = pos-1; i <pos+amount ; i++) {
        int aux = ind.getGene(pos+split);
        ind.setGene(pos+split, ind.getGene(pos));
        ind.setGene(pos, aux);

    }
    }

    @Override
    public String toString() {
       return "mutation 3";
    }
}