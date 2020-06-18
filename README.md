# redecard-springboot-service

Instruções para Uplaod de Arquivos.


<h1>No Projeto</h1>
1°  Em IdentificaoService, Configurar a variavel  <b>DIRETORIO_RAIZ</b> com o diretorio dos Arquivos de Extratos-REDE


<h1>URLs de Acesso</h1>

seuServidor/upload/all    -> Para realizar o upload de todos os arquivos do diretorio.

<h1>Base de Dados</h1>
Em <b>aplication.properties </b> configuracoes do DataSource.
<b>Importante</b>: Criar base uma base de dados com o nome <b>cartoes</b>

<h2>Para executar o projeto é necessário instalar a biblioteca redecard-extrato-reader</h2>

git clone https://github.com/murilotuvani/redecard-extrato-reader
cd redecard-extrato-reader/redecard-extrato-reader
mvn clean package install