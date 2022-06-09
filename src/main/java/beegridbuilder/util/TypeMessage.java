package beegridbuilder.util;

public enum TypeMessage {
	SAVE("Dados salvos com sucesso!"),
	ERROR("Erro no sistema..."),
	DELETE("Dados eliminados com sucesso!");

	String description;
	
	private TypeMessage(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
