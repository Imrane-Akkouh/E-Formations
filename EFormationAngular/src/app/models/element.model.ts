export class Element{
    constructor(
        public id: string,
        public formateurId: string,
        public element_name: string,
        public duration: number,
        public date: Date,
        public cost: number,
        public nb_beneficiaires: number
    ){}
}