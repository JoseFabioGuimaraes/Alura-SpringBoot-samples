public enum ErrorsHTTP {
    NOT_FOUND(404, "Página não encontrada"),
    BAD_REQUEST(400, "Requisição Inválida"),
    INTERNAL_SERVER_ERROR(500,"Error interno do servidor");

    private int codigo;
    private String descricao;

    ErrorsHTTP(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo(){
        return codigo;
    }
    public String getDescricao(){
        return descricao;
    }
}
