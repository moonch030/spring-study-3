package ch03_pjt_03;

public class CalAssembler {

	MyCalculator calculator;
    CalAdd calAdd;
    CalSub calSub;
    CalMul calMul;
    CalDiv calDiv;
    
	/*
	 * public CalAssembler() { calculator = new MyCalculator(); calAdd = new
	 * CalAdd(); calSub = new CalSub(); calMul = new CalMul(); calDiv = new
	 * CalDiv();
	 * 
	 * assemble(); }
	 */
    
    // 매개변수를 받는 생성자
    public CalAssembler(MyCalculator calculator, 
            CalAdd calAdd, CalSub calSub, 
            CalMul calMul, CalDiv calDiv) {
          
      this.calculator = calculator;
          this.calAdd = calAdd;
          this.calSub = calSub;
          this.calMul = calMul;
          this.calDiv = calDiv;
          
      }
    
    // 계산기 조립 메서드
    public void assemble() {
        calculator.calculate(10, 7, calAdd);
        calculator.calculate(10, 5, calSub);
        calculator.calculate(10, 5, calMul);
        calculator.calculate(10, 5, calDiv);     
    }
}
