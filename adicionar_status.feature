#language: pt


Funcionalidade:  Adicionar Status
Eu como usuário do Whatsapp utilizo o status para publicar imagens, videos e frases

Contexto:
Dado que eu estou logado no Whatsapp

@AddStatus
Cenário: Adicionar um status
Quando vou adicionar novo status
E no status seleciono o arquivo para publicar
Então vejo que o novo status foi adicionado

@AddOtherStatus
Cenário: Acrescentar um status na lista de status
Quando quero acrescentar um novo status que já possui um arquivo
E somando com que já existe no status
Então vejo que há um status adicional na lista


@AddPhoto
Cenário: Adicionar um status tirado da camera
Quando utilizo a camera do meu dispositivo para adicionar um novo status
E publico a foto salva 
Então vejo a foto adicionada

@RemoveStatus
Cenário: Remover um status na lista de status
Quando quero remover um  status da minha lista
E seleciono esse status para apagar
Então o status será removido com sucesso
