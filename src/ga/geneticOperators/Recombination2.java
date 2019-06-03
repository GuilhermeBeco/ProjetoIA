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
        System.out.println("Fim primeiro for");
        for (int i = crossPoint2; i <ind1.getNumGenes() ; i++) {
            child1[i]=0;
            child2[i]=0;
        }
        System.out.println("Fim segundo for");
        for (int i = crossPoint1; i <crossPoint2 ; i++) {
            child1[i]=ind2.getGene(i);
            child2[i]=ind1.getGene(i);
        }
        System.out.println("Fim terceiro for");
        for (int i = 0; i <ind1.getNumGenes(); i++) {
            int aux=findFirstZero(child1);
            if(aux!=-1) {
                if (!find(child1, ind2.getGene(i))) {
                    child1[aux] = ind2.getGene(i);
                }
            }else{
                break;
            }
        }
        System.out.println("Fim quarto for");
        for (int i = 0; i <ind1.getNumGenes(); i++) {
            int aux=findFirstZero(child2);
            if(aux!=-1) {
                if (!find(child2, ind1.getGene(i))) {
                    child2[aux] = ind1.getGene(i);
                }
            }else{
                break;
            }
        }
        System.out.println("Fim quinto for");
        for (int i = 0; i < ind1.getNumGenes(); i++) {
            ind1.setGene(i,child1[i]);
            ind2.setGene(i,child2[i]);
        }
        System.out.println("Fim do sexto for");
    }
    public boolean find(int[] child,int value){
        for (int i = 0; i <child.length; i++) {
            if(child[i]==value)
                return true;
        }
        return false;
    }
    public int findFirstZero(int[] child){
        for (int i = 0; i <child.length ; i++) {
            if(child[i]==0){
                return i;
            }
        }
        return -1;
    }

 /*   name="confirmado".$move->id
    $moves=Move::all();
    foreach($moves as $move){
        if($request->has('confirmado'.$move->id))
            DB::update(update movimentos set confirmado=1 where id = ?,[$move->id]);
    }
    */

    @Override
    public String toString(){
        //TODO
        throw new UnsupportedOperationException();
    }    
}