import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MainTest {

    @Test
    public void 메인() {
        boolean message = true;
        Assertions.assertThat(message).isTrue();
    }
}