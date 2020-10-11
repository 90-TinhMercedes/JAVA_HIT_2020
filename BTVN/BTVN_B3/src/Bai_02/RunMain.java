package Bai_02;

import Bai_02.Dog;
public class RunMain {
    public static void main(String[] args) {
        Dog meoDucBo = new Dog();
        meoDucBo.InputName("TranDucBo");
        for (int i=0; i<3; i++){
            meoDucBo.Bark();
            meoDucBo.ShowMP();
        }

    }
}
