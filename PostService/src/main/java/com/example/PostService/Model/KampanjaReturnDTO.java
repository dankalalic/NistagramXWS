package com.example.PostService.Model;

import java.util.List;

public class KampanjaReturnDTO {
    private List<ReklamaReturnDTO> reklame;

    public KampanjaReturnDTO(List<ReklamaReturnDTO> reklame) {
        this.reklame = reklame;
    }

    public KampanjaReturnDTO() {
    }

    public List<ReklamaReturnDTO> getReklame() {
        return reklame;
    }

    public void setReklame(List<ReklamaReturnDTO> reklame) {
        this.reklame = reklame;
    }
}
