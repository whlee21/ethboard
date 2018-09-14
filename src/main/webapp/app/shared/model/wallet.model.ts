export interface IWallet {
    id?: number;
    account?: string;
    userLogin?: string;
    userId?: number;
}

export class Wallet implements IWallet {
    constructor(public id?: number, public account?: string, public userLogin?: string, public userId?: number) {}
}
