public class Converter {

    void convertDistance (int numStep, int rateStepDistance){
        System.out.println("Пройденная дистанция (в км) " + ((numStep * rateStepDistance) / 100000));
    }
    void convertCCal (int numStep, int rateStepCCal){
        System.out.println("Количество сожжённых килокалорий " + ((numStep * rateStepCCal) / 1000));
    }
}
