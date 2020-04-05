export class Formation{
    constructor(
        public formation_name: string,
        public objectives: string,
        public pre_requisites: string,
        public establishment: string,
        public date: Date,
        public nb_places: number,
        public elements: string[]){
        }
}