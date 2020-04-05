export class User {
    
    constructor(
        public id: string, 
        public username: string,
        public rating: number,
        public nbr_reviewers: number,
        public rated_fromations: string[],
        public formations: string[], 
        public role: string,
        ){
    }
    
}