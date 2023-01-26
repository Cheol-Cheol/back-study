package cheolcheol.SpringCoreBasic.singleton;

// 싱글톤 적용한 서비스
public class SingletonService {
    // 인스턴스가 2개 이상 생성되는 것을 방지하기 위해 private과 static으로 클래스 범위에서 내부적으로 선언
    private static final SingletonService instance = new SingletonService();

    // 객체 인스턴스 조회
    public static SingletonService getInstance(){
        return instance;
    }

    // 다른 클래스에서 SingletonService 인스턴스 생성을 방지하고자 private 생성자 선언
    private SingletonService() {}

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}


