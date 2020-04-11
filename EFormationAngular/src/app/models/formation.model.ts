export class Formation{
    constructor(
        public id: string,
        public formation_name: string,
        public formateurId: string,
        public objectives: string,
        public pre_requisites: string,
        public establishment: string,
        public date: Date,
        public nb_places: number,
        public validated: Boolean,
        public elements: string[]){
        }
}