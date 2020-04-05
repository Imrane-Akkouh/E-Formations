export class Element{

    constructor(
        private id: string,
        private reference: string,
        private element_name: string,
        private duration: number,
        private date: Date,
        private cost: number,
        private nb_beneficiaires: number
    ){}
}