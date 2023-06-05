package programmers.java.calulator.console.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import programmers.java.calulator.common.Calculator;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.writer.Writer;

import static org.mockito.Mockito.*;

public class ExecuteCalculationCommandTest {

    @Test
    @DisplayName("사용자의 계산기 실행 명령이 작동하는지 확인하는 테스트")
    public void 계산기_실행_테스트() {
        // given
        Calculator mockCalculator = Mockito.mock(Calculator.class);
        Reader mockReader = Mockito.mock(Reader.class);
        Writer mockWriter = Mockito.mock(Writer.class);

        when(mockReader.readLine()).thenReturn("2 + 2");
        when(mockCalculator.calculate("2 + 2")).thenReturn(4);

        ExecuteCalculationCommand command = new ExecuteCalculationCommand(mockCalculator, mockReader, mockWriter);

        // when
        command.execute();

        // then
        verify(mockCalculator, times(1)).calculate("2 + 2");
        verify(mockWriter, times(1)).write("4");
    }
}
