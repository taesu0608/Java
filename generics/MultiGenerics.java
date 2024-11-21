package generics;

// 3. 다중 generics.Generics
class MultiGenerics<T, U> {
    public void plainMethod(Integer a) {
        System.out.println("plainMethod: " + a.getClass().getName());
    }

    // Generics는 method overloading type구분 불가
    /*
    public void genericsMethod(T a){
        System.out.println("genericsMethod: "+a.getClass().getName());
    }
    public void genericsMethod(U b){
        System.out.println("genericsMethod: "+b.getClass().getName());
    }*/
    public void printMultiGenerics(T a, U b) {
        System.out.print("multiGenericsMethod:" + a.getClass().getName());
        System.out.println("        multiGenericsMethod: " + b.getClass().getName());
    }
}
