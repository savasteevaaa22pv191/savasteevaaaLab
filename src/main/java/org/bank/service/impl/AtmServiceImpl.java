package org.bank.service.impl;

import org.bank.entity.Bank;
import org.bank.entity.BankAtm;
import org.bank.entity.BankOffice;
import org.bank.service.AtmService;
import org.bank.service.BankOfficeService;
import org.bank.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtmServiceImpl implements AtmService {

	private static AtmServiceImpl INSTANCE;
	private final Map<Integer, BankAtm> bankAtms = new HashMap<>();

	private AtmServiceImpl() {
	}

	public static AtmServiceImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AtmServiceImpl();
		}

		return INSTANCE;
	}

	private final BankOfficeService bankOfficeService = BankOfficeServiceImpl.getInstance();

	@Override
	public BankAtm create(BankAtm bankAtm) {
		if (bankAtm != null) {

			if (bankAtm.getId() < 0) {
				System.out.println("Ошибка! ID не может быть отрицательным числом!");
				return null;
			}

			if (bankAtm.getMoney() < 0) {
				System.out.println("Ошибка! Кол-во денег не может быть отрицательным числом!");
				return null;
			}

			if (bankAtm.getServicePrice() < 0) {
				System.out.println("Ошибка! Стоимость обслуживания не может быть отрицательным числом!");
				return null;
			}

			if (bankAtm.getBankOffice() == null) {
				System.out.println("Ошибка! Нельзя создать банкомат без офиса!");
				return null;
			}

			return addBankAtm(new BankAtm(bankAtm));
		}

		return null;
	}

	@Override
	public BankAtm addBankAtm(BankAtm bankAtm) {
		if (bankAtm != null) {

			if (!bankAtms.containsKey(bankAtm.getId())) {
				BankOffice bankOffice = bankAtm.getBankOffice();

				if (bankOffice != null) {
					if (bankOfficeService.addAtm(bankOffice.getId(), bankAtm)) {
						bankAtms.put(bankAtm.getId(), bankAtm);
						return bankAtms.get(bankAtm.getId());
					}
				} else {
					System.out.println("Нельзя добавить офис с пустым банком");
				}
			} else {
				System.out.println("Нельзя добавить офис: офис с таким id уже существует");
			}
		} else {
			System.out.println("Нельзя добавить офис: офис не может быть null");
		}

		return null;
	}

	@Override
	public BankAtm getBankAtmById(int id) {
		BankAtm bankAtm = bankAtms.get(id);

		if (bankAtm == null) {
			System.out.println("Банкомат с id = " + id + " не существует");
		}

		return bankAtm;
	}

	@Override
	public List<BankAtm> getAllBankAtm() {
		return new ArrayList<BankAtm>(bankAtms.values());
	}

	@Override
	public List<BankAtm> getAllBankAtmByIdBankOffice(int id) {
		List<BankAtm> bankAtmByOfficeId = bankAtms.values().stream().filter(
				atm -> atm.getBankOffice().getId() == id).toList();

		return bankAtmByOfficeId;
	}

	@Override
	public Boolean deleteBankAtm(int bankAtmId) {
		BankAtm bankAtm = bankAtms.get(bankAtmId);
		if (bankAtm != null) {
			if (bankOfficeService.deleteAtm(bankAtm.getBankOffice().getId(), bankAtmId)) {
				return bankAtms.remove(bankAtmId) != null;
			}
		}
		return false;
	}

	@Override
	public String read(int bankAtmId) {
		BankAtm bankAtm = getBankAtmById(bankAtmId);

		if (bankAtm != null) {
			return bankAtm.toString();
		}
		return "";
	}

	@Override
	public void depositMoney(int bankAtmId, double sum) {
		BankAtm bankAtm = getBankAtmById(bankAtmId);
		if ((bankAtm != null) && (bankAtm.getBankOffice() != null) && (bankAtm.getBank() != null)) {

			if (bankAtm.getStatus() != Status.NOT_WORK) {
				if (bankAtm.getIsPayInMoney()) {
					BankOffice office = bankAtm.getBankOffice();
					Bank bank = bankAtm.getBank();
					double newSum = bankAtm.getMoney() + sum;

					bankAtm.setMoney(newSum);
					office.setMoney(office.getMoney() + newSum);
					bank.setMoney(bank.getMoney() + newSum);
				} else {
					System.out.println("В банкомат " + bankAtm.getName() + " нельзя вносить деньги\n");
				}
			} else {
				System.out.println("Банкомат " + bankAtm.getName() + " не работает\n");
			}
		}
	}

	@Override
	public void withdrawMoney(int bankAtmId, double sum) {
		BankAtm bankAtm = getBankAtmById(bankAtmId);
		if ((bankAtm != null) && (bankAtm.getBankOffice() != null) && (bankAtm.getBank() != null)) {

			if (bankAtm.getStatus() == Status.WORK) {
				if (bankAtm.getIsGiveMoney()) {
					if (bankAtm.getMoney() >= sum) {

						BankOffice office = bankAtm.getBankOffice();
						Bank bank = bankAtm.getBank();
						double newSum = bankAtm.getMoney() - sum;

						bankAtm.setMoney(newSum);
						office.setMoney(office.getMoney() + newSum);
						bank.setMoney(bank.getMoney() + newSum);
					} else {
						System.out.println("В банкомате" + bankAtm.getName() + " недостаточно денег для выдачи\n");
					}
				} else {
					System.out.println("Банкомат " + bankAtm.getName() + " не работает на выдачу денег\n");
				}
			}
		}
	}

	@Override
	public void updateBank(int id, Bank bank) {
		BankAtm bankAtm = bankAtms.get(id);

		if (bankAtm != null) {
			if (bank != null) {
				bankAtm.setBank(bank);
			} else {
				System.out.println("Невозможно обновить банк у банкомата: банк не может быть null\n");
			}
		} else {
			System.out.println("Невозможно обновить банк у банкомата: банкомат не может быть null\n");
		}
	}
}
