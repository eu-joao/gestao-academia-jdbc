# 🤝 Como contribuir com o projeto

## Pré-requisitos

- **Git**: [git-scm.com](https://git-scm.com) — instale com as opções padrão
- **JDK 17+**: [adoptium.net](https://adoptium.net) — marque **"Add to PATH"** e **"Set JAVA_HOME"** durante a instalação
- **Maven**: [maven.apache.org/download](https://maven.apache.org/download.cgi) — adicione a pasta `bin` ao PATH manualmente

---

## Configuração inicial

```bash
# 1. Clonar o repositório
git clone https://github.com/SEU_USUARIO/NOME_DO_REPO.git
cd NOME_DO_REPO

# 2. Instalar dependências e compilar
mvn install

# 3. Rodar o projeto
mvn exec:java
```

---

> **Toda vez que for trabalhar**, lembre de executar `git pull` antes de começar.
