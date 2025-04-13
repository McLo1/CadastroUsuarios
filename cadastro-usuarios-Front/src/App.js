import React, { useState } from "react";
import axios from "axios";

function App() {
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    const usuario = { nome, email, senha };

    axios.post("http://localhost:8080/usuario", usuario)
      .then(response => {
        alert("Usuário cadastrado com sucesso!");
        console.log(response.data);
        // Limpa os campos
        setNome("");
        setEmail("");
        setSenha("");
      })
      .catch(error => {
        alert("Erro ao cadastrar usuário!");
        console.error(error);
      });
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Cadastro de Usuário</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Nome:</label><br />
          <input type="text" value={nome} onChange={(e) => setNome(e.target.value)} />
        </div>
        <div>
          <label>Email:</label><br />
          <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
        </div>
        <div>
          <label>Senha:</label><br />
          <input type="password" value={senha} onChange={(e) => setSenha(e.target.value)} />
        </div>
        <button type="submit" style={{ marginTop: "10px" }}>Cadastrar</button>
      </form>
    </div>
  );
}

export default App;
