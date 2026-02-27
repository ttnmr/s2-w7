import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * WildlifeSimulator - Manages population dynamics for multiple species
 * Uses an array of Species objects to store and simulate species data
 */
public class WildlifeSimulator {
    private Species[] species;
    private int speciesCount;
    
    public WildlifeSimulator(int maxSpecies) throws FileNotFoundException {
        species = new Species[maxSpecies];
    }
    
    /**
     * Add a species to the simulator
     */
    public void addSpecies(Species s) {
        if (species.length < (int) (0.8*speciesCount)) {
            Species[] temp = new Species[species.length*2];
            for (int i = 0; i < speciesCount; i++) {
                temp[i] = species[i];
            }
            species = temp;
        }
        species[speciesCount] = s;
        speciesCount++;
    }
    
    /**
     * Simulate one year of population changes for all species
     */
    public void simulateYear() {
        for (Species s: species) {
            s.simulateYear();
        }
    }
    
    /**
     * Simulate multiple years
     */
    public void simulate(int years) {
        for (int i = 0; i < years; i++) {
            simulateYear();
        }
    }
    
    /**
     * Get species at given index
     */
    public Species getSpecies(int index) {
        return species[index];
    }
    
    /**
     * Get species info as formatted string
     */
    public String getSpeciesInfo(int index) {
        return species[index].toString();
    }
    
    /**
     * Get total wildlife count across all species
     */
    public double getTotalPopulation() {
        Long total = (long) 0; 
        for (int i = 0; i < speciesCount; i++) {
            total += species[i].getPopulation();
        }
        return total;
    }
    
    /**
     * Find the species with largest population
     */
    public int getMostPopulousIndex() {
        Long max = (long) 0;
        int idx = -1;
        for (int i = 0; i < speciesCount; i++) {
            if (species[i].getPopulation() > max) idx = i;
        }
        return idx;
    }
    
    /**
     * Find the species with smallest population (most endangered)
     */
    public int getMostEndangeredIndex() {
        Long min = (long) 0;
        int idx = -1;
        for (int i = 0; i < speciesCount; i++) {
            if (species[i].getPopulation() < min) idx = i;
        }
        return idx;
    }
    
    public int getSpeciesCount() {
        return speciesCount;
    }
    
    /**
     * Get array of all species
     */
    public Species[] getSpeciesArray() {
        return species;
    }
}
