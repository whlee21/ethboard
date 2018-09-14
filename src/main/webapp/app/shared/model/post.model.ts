export interface IPost {
    id?: number;
    title?: string;
    content?: string;
    ownerName?: string;
    ownerAccount?: string;
}

export class Post implements IPost {
    constructor(
        public id?: number,
        public title?: string,
        public content?: string,
        public ownerName?: string,
        public ownerAccount?: string
    ) {}
}
