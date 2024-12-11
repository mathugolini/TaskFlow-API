package hugolini.taskflowapi.dto;

import java.util.Map;

public class TarefasPorStatusDTO {

    private Map<String, Long> contagemPorStatus;

    public TarefasPorStatusDTO(Map<String, Long> contagemPorStatus) {
        this.contagemPorStatus = contagemPorStatus;
    }

    public Map<String, Long> getContagemPorStatus() {
        return contagemPorStatus;
    }

    public void setContagemPorStatus(Map<String, Long> contagemPorStatus) {
        this.contagemPorStatus = contagemPorStatus;
    }
}
