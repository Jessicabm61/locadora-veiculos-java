namespace Exercício14.Entities
{
    class BusinessAccount : Account //  ": Account" Informa que a classe business Account é a herança da classe Accounnt
    {
        public double LoanLimit { get; set; }

        public BusinessAccount() //Construtor vazio permite criar um objeto sem passar os dados
        {
        }

        /*Ao invés de criar um construtor repetindo todas as variáveis da classe Account conforme abaixo é possível somente
        * acionar o contrutor da Classe Account utilizando base()
        public BusinessAccount(int number, string holder, double balance, double loanLimit) 
        {
        Number = number;
        Holder = holder;
        Balance = balance;
        LoanLimit = loanLimit;
        }*/

        public BusinessAccount(int number, string holder, double balance, double loanLimit) :
        base(number, holder, balance)
        {
            LoanLimit = loanLimit;
        }

        public void Loan(double amount)
        {
            if (amount <= LoanLimit)
                Balance += amount;
        }
    }
}