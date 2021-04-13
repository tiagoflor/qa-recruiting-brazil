#language: pt


Funcionalidade:  Adicionar Contato

Para usar Whatsapp como meio comunicação
Eu como usuário desejo utilizar funcionalidade de adicionar, excluir ou bloquear contato do Whatsapp para conversas e demais assuntos.


Contexto:
Dado que eu estou logado no Whatsapp


@NotExisting
Cenário: Adicionar um contato não existente na lista de contatos
Quando  adiciono um novo contato na lista de contatos
E salvando o contato
Então vejo que o contato foi adicionado

@AlreadyExisting
Cenário: Adicionar um novo número celular para um contato já existente
Quando busco um contato existente na minha lista
E adicionando novo número
Então vejo que foi adicionado os novos dados


@AddQr
Cenário: Adicionar um novo contato via QR Code
Quando quero adicionar um contato via QR Code
E recebo um contato por mensagem
Então vejo o novo contato na minha lista de contatos

@ExcludeContact
Cenário: Excluir contato presente na lista
Quando quero excluir de minha lista um contato
E removo contato
Então vejo que o contato removido da minha lista

@BlockContact
Cenário: Bloquear contato
Quando desejo bloquear o contato
E bloqueio um contato
Então vejo que contato foi bloqueado na lista


